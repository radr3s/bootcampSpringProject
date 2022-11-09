# bootcampSpringProject
Merhaba, öncelikle bu imkanı sunduğunuz için Önder Hocama ve Fibabanka'ya teşekkür ederim. Mevcutta çalıştığımdan dolayı ödevleri yapacak vakit bulamasam da hocamızın anlattıklarını pratiğe dökmek ve Fibabanka Speed Bootcamp kapsamında spring' de kendimi geliştirmek istediğim için projeyi elimden geldiğimce belirtilen mimaride tamamlamaya çalıştım. Aşağıda örnek işlemleri ekran görüntüleriyle beraber anlatmaya çalıştım. 

Proje inventory ve shopping olmak üzere 2 tane db ve inventory,shopping,commerce mikroservisleri olmak üzere 3 tane spring servisini içermektedir. Commerce servisi veriyi görselleştirmek açısından postman kullanarak test edilmiştir. Ek olarak commerce servisi restTemplate ile inventory ve shopping servislerini çağırmaktadır.

inventory db => category table
![image](https://user-images.githubusercontent.com/72450893/200873584-ec213be8-87cb-437f-93c2-2594208fc32e.png)

inventory db => product table
![image](https://user-images.githubusercontent.com/72450893/200875595-02a55f70-c154-4d53-8562-2029d880ad03.png)

sepet oluşturma
![image](https://user-images.githubusercontent.com/72450893/200891708-55ef3125-077d-4104-84be-6253fdcf3c32.png)

sepete ürün ekleme
![image](https://user-images.githubusercontent.com/72450893/200892096-2603e8dc-d16f-427a-b599-108f496a8254.png)
![image](https://user-images.githubusercontent.com/72450893/200892208-cb780ed4-5939-46c1-961a-0e9c070fb899.png)
![image](https://user-images.githubusercontent.com/72450893/200892355-92838aff-5bb2-4f3b-9125-886ec1532f45.png)

sepetten ürün çıkarma
![image](https://user-images.githubusercontent.com/72450893/200892650-b0a3cc87-a1d6-4b1e-99b0-80d6cd13e3b9.png)

sepet checkout
![image](https://user-images.githubusercontent.com/72450893/200892938-5df09675-48f3-4f28-a7c8-f721494d702c.png)

shopping db => cart table
![image](https://user-images.githubusercontent.com/72450893/200893087-a60f40ba-77af-40ae-be71-68d7823eec52.png)

shopping db => cart_product table
![image](https://user-images.githubusercontent.com/72450893/200893235-1413defb-7edf-4350-bb13-3d1fae6a26c6.png)
