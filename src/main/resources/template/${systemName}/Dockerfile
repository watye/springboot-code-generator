FROM registry.talelife.com/library/java:v1.8
VOLUME /tmp
ADD ./${systemName}-web/target/${systemName}.jar /${systemName}.jar
EXPOSE ${port}
ENV SPRING_PROFILES_ACTIVE "prd"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xms768m -Xmx768m","-jar","/${systemName}.jar","--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]