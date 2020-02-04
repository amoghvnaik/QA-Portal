pipeline{
        agent any
        
        stages{
		stage('--building--'){
			steps{
				sh '''ssh deployment
				      cd QA-Portal/qa-portal-services/
                                      git pull
				      mvn clean install
				      docker-compose build
				      docker-compose push
                                      kubectl apply -f kubectl.yaml
				      '''
			}
		}
        }
}
