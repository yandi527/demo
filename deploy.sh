kubectl create secret docker-registry regcred --docker-server=localhost:5005 --docker-username=admin --docker-password=0000
kubectl apply -f demo.yaml
