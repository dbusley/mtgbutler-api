@Library('github.com/releaseworks/jenkinslib') _

pipeline {
    agent { docker { image 'maven:latest' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('publish') {
            when {
                branch 'master'
            }
            steps {
                script {
                    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'production', usernameVariable: 'AWS_ACCESS_KEY_ID', passwordVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                        withElasticContainerRegistry {
                            def app = docker.build("mtgbutler-api")
                            app.push('latest');
                        }
                    }
                }
                sh 'aws ecs update-service --cluster mtgbutler-production --service api --force-new-deployment'
            }
        }
    }
}