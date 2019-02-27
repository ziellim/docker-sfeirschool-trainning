FROM node:alpine

LABEL image-name docker-sfeirschool-trainning-front

EXPOSE 4200

WORKDIR /front

COPY . .

RUN npm install

ENTRYPOINT ["npm", "start"]