import requests

BASE_ROUTE = "http://localhost:8080/"

response = requests.get(BASE_ROUTE)
print(response.content)