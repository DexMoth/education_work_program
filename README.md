### Перед использованием                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
Развернуть бд:
1. Скачать db work program.backup
2. Зайти в pg admin, создать новую бд
3. нажать на новую бд и выбрать Restore
4. Указать файлик .backup

### Как запустить?
1. Запустить сервер

Все настройки сервера в src/main/resourses/application.properties. 
Там указана почта, которая отсылает письма с кодом и
имя бд (`spring.datasource.url=`, у меня она названа work_program)

2. Запустить веб:
   1. проверь, что есть node.js;
   2. в терминале: <br>
   `npm install bootstrap` <br>
   `npm install vue` <br>
   `npm install pinia`
   3. если будет ругаться, что нет какого-то пакета, то также его установить
   4. запустить через терминал:
  ` npm run dev`