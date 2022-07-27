set JAVA_HOME=%USERPROFILE%\.jdks\openjdk-17.0.2

.\apache-maven-3.8.6\bin\mvn.cmd clean install && ^

heroku container:login && ^
heroku container:push web -a agile-journey-dev && ^
heroku container:release web -a agile-journey-dev && ^
heroku logs -a agile-journey-dev --tail

