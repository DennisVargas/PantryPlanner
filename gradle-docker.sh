#!/bin/bash
docker run --rm -v "$PWD":/home/gradle/project -v "$PWD"/.gradle:/home/gradle/.gradle -w /home/gradle/project gradle:latest gradle "$@"
