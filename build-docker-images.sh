docker buildx build --platform=linux/amd64 --tag=finda/magazyn-server:latest.amd .
docker buildx build --platform=linux/arm64 --tag=finda/magazyn-server:latest.arm .
