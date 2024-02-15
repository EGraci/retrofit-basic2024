# Retrofit Basic 2024

## install library retrofit Gradle Kts
```
    implementation("com.google.code.gson:gson:2.7")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
```

## Allow Http and Internet Acces
```
  <uses-permission android:name="android.permission.INTERNET" />
   <application
        android:usesCleartextTraffic="true"

        android:allowBackup="true"
        ...
```

## Setting local ip in file MainActivity.java
```
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://your_ip/basic/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```
