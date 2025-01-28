import requests
import json
BASE_ROUTE = "http://localhost:8080"
PATH = "/savenote?userId=1"

requestBody = {'name':'Diary30','note':'Hello hi'}
response = requests.post(
    BASE_ROUTE + PATH,
    headers = {"Content-Type":"application/json"},
    json = json.dumps(requestBody)
)

if (response.ok):
    print(f'Response : {response.status_code}')
    print(f'JSON : {response.json()}')
