# ProgKorny2025

Az elképzelés az volt hogy csinálok egy több játékból is választható kaszinót.
Először terminálban futtatható verziót csináltam, majd az órai előadásokat követve próbáltam átalakítani a követelményeknek megfelelően.
Sajnos ezzel a folyamattal több idő ment el, mint terveztem és ezért van ennyi fölösleges fájllal tele a projekt.

Jelenleg csak egy játék lett létrehozva, de a működő funkciók:
-regisztrálás
-login
-játékosok létrehozása
-játékosok törlése
-zseton generálása
-játék futtatása
-értékek mentése
-kijelentkezés

H2 adatbázisban tároljuk az adatokat.
Az adatbázis két táblát tárol: users - players
    Egy usernek lehet több player-e, viszont minden playerhez, csak egy user tartozik
