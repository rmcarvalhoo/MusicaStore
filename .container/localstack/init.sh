awslocal secretsmanager create-secret --name core-credentials --secret-string '{"clientId": "pda", "clientSecret": "pda-secret"}' --region sa-east-1
awslocal secretsmanager create-secret --name jwt-core-credentials --secret-string '{"clientId": "jwt-pada", "clientSecret": "pda-secret"}' --region sa-east-1
awslocal s3api create-bucket --bucket cremildo-bucket
