#!/bin/bash
echo "Starting sample web application"
java -jar ${project.build.finalName}.${project.packaging}
echo "Application started"
