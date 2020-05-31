#!/bin/bash -xe

pathAlunos=$1
pathCursos=$2
pathBaseRendimentos=$3

mvn clean compile assembly:single

if [ -z "${pathAlunos}" -a -z "${pathCursos}" -a -z "${pathBaseRendimentos}" ]
then
  echo "POR FAVOR, INFORME TODOS OS CAMINHOS NECESSARIOS (Path csv Alunos, path csv Cursos e path base rendimentos)"
  exit 1
fi

JAR="deploy/aps-cc-unip-*-dist.jar"

java -jar $JAR $pathAlunos $pathCursos $pathBaseRendimentos
