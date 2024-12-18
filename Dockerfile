FROM openjdk:17-jdk-slim

# tzdata 패키지 설치 및 시간대 설정
RUN apt-get update && apt-get install -y tzdata && \
    ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime && \
    echo "Asia/Seoul" > /etc/timezone

EXPOSE 8080

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} weski-app.jar

CMD java -Dserver.port=8080 \
        -Dspring.datasource.username=master \
        -Dspring.datasource.password=master \
        -jar /weski-app.jar