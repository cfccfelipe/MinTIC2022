from django.shortcuts import render
from . import forms
from pymongo import MongoClient
client = MongoClient('mongodb://localhost:27017/')
db_tienda_virtual = client.tiendaVirtual
from datetime import datetime

def home(request):
    return render(request, 'tienda_virtual/index.html')

def carrito(request):
    productos = [] 
    cursor = db_tienda_virtual['carrito'].find()
    for document in cursor:
        temp = {}
        temp['nombre'] = document['nombre']
        temp['costo'] = document['costo_unidad']
        temp['cantidad'] = document['cantidad']
        productos.append(temp)
 
    parametros = {'productos':  productos}
    return render(request, 'tienda_virtual/carrito_compras.html', parametros)

def historial(request):
    historial = []
    cursor = db_tienda_virtual['compras'].find()
    contador = 0
    for document in cursor:
        temp = {}
        temp['numero'] = contador
        temp['nombre'] = document['nombre_cliente']
        temp['costo'] = document['costo']
        temp['productos'] = document['productos']
        temp['fecha'] = document['fecha']
        temp['metodo'] = document['metodo_pago']
        temp['observaciones'] = document['observaciones']
        temp['direccion'] = document['direccion']
        historial.append(temp)
        contador += 1
    parametros = {'historial':  historial}
    return render(request, 'tienda_virtual/historial.html', parametros)

def productos(request):
    productos = []
    cursor = db_tienda_virtual['productos'].find()
    for document in cursor:
        temp = {}
        temp['nombre'] = document['nombre']
        temp['costo'] = document['costo']
        productos.append(temp)
    if request.method == 'POST': 
        frm_agregar = forms.agregar_producto(request.POST) 
 
        if frm_agregar.is_valid():
            producto = {}
            producto['nombre'] = request.POST.get('producto')
            producto['cantidad'] = request.POST.get('cantidad')
 
            datos_producto = db_tienda_virtual['productos'].find({'nombre': producto['nombre']}, {'costo': 1})
            producto['costo_unidad'] = datos_producto[0]['costo']
 
            db_tienda_virtual['carrito'].insert_one(producto)
    frm_agregar = forms.agregar_producto()
    parameters = {'frm_agregar' :  frm_agregar}
    return render(request, 'tienda_virtual/lista_productos.html', parameters)


def pagos(request):
    costo = 0
    listado_productos = ""
    cursor = db_tienda_virtual['carrito'].find()
    for document in cursor:
        costo += int(document['costo_unidad']) * int(document['cantidad'])
        listado_productos +=  str(document['cantidad']) + ' ' + document['nombre'] + '\n'
    
    if request.method == 'POST': 
        frm_pago = forms.pagar_carrito(request.POST) 
        if frm_pago.is_valid():
            pago = {}
            pago['productos'] = listado_productos
            pago['metodo_pago'] = request.POST.get('metodo_pago')
            pago['nombre_cliente'] = request.POST.get('nombre')
            pago['direccion'] = request.POST.get('direccion')
            pago['observaciones'] = request.POST.get('observaciones')
            pago['fecha'] = datetime.now().strftime("%d/%m/%Y")
            pago['costo'] = costo
            print(pago)
            costo = 0
 
            db_tienda_virtual['carrito'].drop()
            db_tienda_virtual['compras'].insert_one(pago)   
    frm_pago = forms.pagar_carrito()
    parameters = {'frm_pago' :  frm_pago}
    return render(request, 'tienda_virtual/pagar.html', parameters)