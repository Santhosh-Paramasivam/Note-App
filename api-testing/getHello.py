import requests

BASE_ROUTE = "http://localhost:8080"
PATH = "/note?userId=2"

response = requests.get(BASE_ROUTE + PATH)
print(response.json())
