import json
from pprint import pprint

import requests
from django.test import TestCase

class APITest(TestCase):

    def test_json_api(self):
        url = "https://gateway.marvel.com:443/v1/public/characters?ts=1&apikey=89768f35c76a6d489c0302a3e63c3515&hash=a6f60efb9ba95fbce087d205842af713"
        response = requests.get(url)
        if response.status_code == 200:
            print(response.status_code)
            lista = []
            json_response = json.loads(response.text)
            for personaje in json_response['data']['results']:
                nombre = personaje["name"]
                descripcion = personaje["description"]
                comics_disponibles = personaje["comics"]["available"]
                series_disponibles = personaje["series"]["available"]
                dic = {"nombre": nombre, "descripcion": descripcion, "comics_disponibles": comics_disponibles,
                       "series_disponibles": series_disponibles}
                lista.append(dic)
            pprint(lista)
            print(len(lista))
