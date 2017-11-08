#!/bin/bash

kubectl delete rc --all
kubectl delete deployment --all
kubectl delete svc --all
kubectl delete ing --all
kubectl delete statefulsets --all
# kubectl delete pvc --all
