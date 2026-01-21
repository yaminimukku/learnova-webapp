pipeline {
    agent any
    stages {
         stage ('checkout') {
        steps {
          checkout scm
           }
         }  
         stage ('build') {
            steps {
                echo "building  branch: ${env.BRANCH_NAME}"
                sh 'mvn clean package'
            }
         } 
         stage ('test') {
            steps {
                sh 'mvn test'
                echo "test completed"
            }
         }
    }  
}