pipeline{
        agent any
        
        stages{
		stage('--building--'){
			steps{
				sh '''ssh deployment << EOF
				      cd QA-Portal/qa-portal-services/
                                      git pull
				      git checkout week12-week3-frontend
				      mvn clean install
				      cd ..
				      docker-compose build
				      docker-compose push
                                      sed "s/{{BUILD}}/${BUILD_NUMBER}/g" ./kubernetes.yaml | kubectl apply -f -
				      EOF
				      '''
			}
		}
        }
}
