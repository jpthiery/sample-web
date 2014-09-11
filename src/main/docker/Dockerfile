FROM jpthiery/java8
MAINTAINER Jean-Pascal Thiery <jean-pascal@thiery.in>

ADD app /app
RUN chmod +x -R /app

WORKDIR /app
EXPOSE 4567
ENTRYPOINT ./start.sh
