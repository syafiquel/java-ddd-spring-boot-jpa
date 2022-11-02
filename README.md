# spring-boot-hibernate-postgres
A repo for personal journey to become a fullstack Java developer
This project repository is a demo of Spring Boot Web Application that demonstrates the usage of REST API.
The data used in this project is obtained from an Public Open Data Sharing Platform by Malaysian Goverment Agency MAMPU (https://www.data.gov.my/data/ms_MY/dataset)
This web application serves as a platform to search and update a list of films that have been approved by Mininstry of Home Affairs (KDN). The web application is also 
equipped with deployment tools to enable local Kubernetes cluster deployment via Minikube and Helm Chart.

Running the Spring Boot Application

1. Using docker-compose

docker-compose up -d


2. Using Minikube via Helm Chart

  1. Build Image Locally (Kubernetes imagePullPolicy)

     docker build -t spring-boot-hibernate-postgres-app .
    
     docker build -t spring-boot-hibernate-postgres-db .
    
  2. Push the image into Minikube

     minikube cache add spring-boot-hibernate-postgres-app
     
     minikube cache add spring-boot-hibernate-postgres-db
     
  3. Run Helm Chart deployment

     helm install --name film-app ./deployment
