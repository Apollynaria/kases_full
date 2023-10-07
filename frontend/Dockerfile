FROM node:lts-alpine

ENV NODE_OPTIONS=--max_old_space_size=4096

# устанавливаем простой HTTP-сервер для статики
# RUN npm install -g http-server

# делаем каталог 'app' текущим рабочим каталогом
WORKDIR /app

# копируем оба 'package.json' и 'package-lock.json' (если есть)
COPY package*.json ./

# устанавливаем зависимости проекта
RUN npm install

# копируем файлы и каталоги проекта в текущий рабочий каталог (т.е. в каталог 'app')
COPY . .

# собираем приложение для production с минификацией
# RUN npm run build

EXPOSE 4200
#CMD [ "http-server", "dist" ]
CMD [ "npm", "run", "prod" ]
