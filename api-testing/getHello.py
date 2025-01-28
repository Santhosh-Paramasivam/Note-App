import requests

BASE_ROUTE = "http://localhost:8080"
PATH = "/authuser?username=1234&password=abcd"

response = requests.get(BASE_ROUTE + PATH)

if (response.ok):
    print(f'Response : {response.status_code}')
    print(f'JSON : {response.json()}')
