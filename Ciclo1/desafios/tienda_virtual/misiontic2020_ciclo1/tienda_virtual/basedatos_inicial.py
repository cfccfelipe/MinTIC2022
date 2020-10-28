from pymongo import MongoClient
lista_inicial = [
    {'nombre': "Balón", 'costo': 10000},
    {'nombre': "Chaqueta", 'costo': 85000},
    {'nombre': "Libro", 'costo': 12000},
    {'nombre': "Pantalón", 'costo': 90000},
    {'nombre': "Computador", 'costo': 2500000},
    {'nombre': "Silla", 'costo': 400000},
    {'nombre': "Celular", 'costo': 1250000},
    {'nombre': "Raqueta", 'costo': 250000},
    {'nombre': "Tablet", 'costo': 600000},
    {'nombre': "Mesa", 'costo': 172000},
    {'nombre': "Camiseta", 'costo': 28000},
    {'nombre': "Cámara", 'costo': 2450000},
    {'nombre': "Billetera", 'costo': 62000},
    {'nombre': "Sofá", 'costo': 450000},
    {'nombre': "Alcancia", 'costo': 15000}
]
 
db = MongoClient('mongodb://localhost:27017/').tiendaVirtual
ids_ = db.productos.insert_many(lista_inicial)
print(ids_)
client = MongoClient('mongodb://localhost:27017/')
db_tienda_virtual = client.tiendaVirtual
