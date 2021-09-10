FROM tomcat:9.0.27-jdk8-adoptopenjdk-openj9

RUN rm -rf ${CATALINA_HOME}/webapps/*
COPY target/spring-boot-stripes-1.0-SNAPSHOT.war ${CATALINA_HOME}/webapps/ROOT.war

ENV JPDA_ADDRESS=8000
ENV JPDA_TRANSPORT=dt_socket

EXPOSE 8000 8080

CMD [ "catalina.sh", "jpda", "run" ]
