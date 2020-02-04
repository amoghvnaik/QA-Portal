pipeline{
        agent any
        
        stages{
		stage('--building--'){
			steps{
				sh '''ssh deployment
				      docker-compose build
				      docker-compose push
                                      kubectl apply -f kubectl.yaml
				      '''
			}
		}
        }
}
