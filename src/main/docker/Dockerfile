#FROM maven as build
#COPY src /home/hello-quarkus/src
#COPY pom.xml /home/hello-quarkus
#RUN mvn -f /home/hello-quarkus/pom.xml clean package -DskipTests
#
#FROM openjdk:11 as production
#RUN mkdir /deployments
#COPY --from=build /home/hello-quarkus/target/quarkus-app/lib/ /deployments/lib/
#COPY --from=build /home/hello-quarkus/target/quarkus-app/*.jar /deployments/
#COPY --from=build /home/hello-quarkus/target/quarkus-app/app/ /deployments/app/
#COPY --from=build /home/hello-quarkus/target/quarkus-app/quarkus/ /deployments/quarkus/
#
#EXPOSE 8080
#
#CMD ["java", "-jar", "/deployments/quarkus-run.jar"]

FROM openjdk:11
# создание каталога deployments во время создания образа и копирование туда
# приложения и всех необходимых для его работы файлов
RUN mkdir /deployments
COPY target/quarkus-app/lib/ /deployments/lib/
COPY target/quarkus-app/*.jar /deployments/
COPY target/quarkus-app/app/ /deployments/app/
COPY target/quarkus-app/quarkus/ /deployments/quarkus/
# указание того, что приложение в контейнере будет работать на порту 8080 для
# дальнейшей возможности проброса порта с хоста в контейнер
EXPOSE 8080
# запуск приложения при запуске контейнера
CMD ["java", "-jar", "/deployments/quarkus-run.jar"]
