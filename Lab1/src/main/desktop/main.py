import requests

r = requests.get("http://localhost:8080/servlet_war/lab1")

print(r.text)