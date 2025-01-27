import requests

BASE_ROUTE = "http://localhost:8080"
PATH = "/user?id=1"

response = requests.get(BASE_ROUTE + PATH)

print("Status Code:", response.status_code)
print("Response JSON:", response.content) 
