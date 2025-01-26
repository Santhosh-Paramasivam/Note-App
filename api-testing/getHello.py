import requests

BASE_ROUTE = "http://localhost:8080"
PATH = "/note"

response = requests.get(BASE_ROUTE + PATH)
print(response.json())
