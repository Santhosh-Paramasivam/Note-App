import requests

BASE_ROUTE = "http://localhost:8080"
PATH = "/noteuser?userId=1"

response = requests.get(BASE_ROUTE + PATH)
print(response.json())
