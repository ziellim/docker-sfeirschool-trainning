FROM maven:3-jdk-8

LABEL image-name docker-sfeirschool-trainning

EXPOSE 8086

WORKDIR /back

COPY . .

RUN mvn dependency:resolve

RUN mvn install -DskipTests=true

ENTRYPOINT ["mvn", "spring-boot:run"]