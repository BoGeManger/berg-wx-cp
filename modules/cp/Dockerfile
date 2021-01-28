FROM java:8
VOLUME /tmp
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone
COPY target/cp-1.0.0-SNAPSHOT.jar cp.jar
RUN bash -c "touch /cp.jar"
EXPOSE 43000
ENV w=0 d=0
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-XX:+HeapDumpOnOutOfMemoryError","-jar","cp.jar","--snowflake.id.worker.workerId=${w}","--snowflake.id.worker.datacenterId=${d}"]