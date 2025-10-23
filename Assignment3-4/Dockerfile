FROM openjdk:17-slim
WORKDIR /app
COPY *.java /app
RUN javac *.java
COPY run.sh /app

# Fix permissions AND line endings
RUN chmod +x ./run.sh \
    && sed -i 's/\r$//' ./run.sh

CMD ["./run.sh"]