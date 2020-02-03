FROM node:10 AS build
RUN npm install -g @angular/cli@8.3.20
WORKDIR /build
COPY package*.json ./
RUN npm install
COPY . .
#RUN npm test
RUN npm run build

FROM nginx:1.13.12-alpine
COPY --from=build /build/dist/portal-core /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
