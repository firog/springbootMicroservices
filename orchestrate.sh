#!/bin/bash

kubectl run nginx --image=nginx --port=80
kubectl expose deployment nginx --target-port=80 --type=NodePort

kubectl create -f mongodb-controller.yaml
kubectl create -f mongodb-service.yaml

#kubectl create -f customer-deployment.yaml
#kubectl create -f customer-service.yaml

kubectl create -f store-deployment.yaml
kubectl create -f store-service.yaml

kubectl create -f ingress.yaml
