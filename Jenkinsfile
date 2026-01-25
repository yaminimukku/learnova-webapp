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
         stage ('sonarqube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn sonar:sonar'
                }
            }
         }
        //  stage ('qualitygate') {
        //     steps {
        //         timeout(time: 2, unit: 'MINUTES') {
        //               waitForQualityGate abortPipeline: true
        //         }
        //     }
        //  }
        stage('nexus') {
           steps {
        // Use Jenkins credentials securely
        withCredentials([usernamePassword(
            credentialsId: 'nexus-jenkinscred', // ID of your Jenkins credential
            usernameVariable: 'NEXUS_USER', 
            passwordVariable: 'NEXUS_PASS'
        )]) {
            // Run Maven deploy, it will pick up NEXUS_USER/NEXUS_PASS from settings.xml
            sh 'mvn clean deploy -DskipTests'
        }
    }
}

    }  
}
             






