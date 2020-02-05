pipeline{
        agent any
        
        stages{
		stage('--building--'){
			steps{
				sh '''ssh deployment << EOF
				      export BUILD_NUMBER=${BUILD_NUMBER}
				      cd QA-Portal/qa-portal-services/
                                      git pull
				      git checkout week12-week3-frontend
				      mvn install -DskipTests
				      cd ..
				      docker-compose build
				      docker-compose push
                                      sed "s/{{BUILD}}/${BUILD_NUMBER}/g" ./kubernetes.yaml | kubectl apply -f -
				      '''
			}
		}
        }
}
