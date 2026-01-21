pipeline {
    agent any
    stages {
         stage ('checkout') {
        steps {
            git branch: 'feature/yamini' ,
            url: https://github.com/yaminimukku/learnova-webapp.git
           }
         }  
         stage ('build') {
            steps {
                echo "build sucess"
            }
         } 
    }  
}