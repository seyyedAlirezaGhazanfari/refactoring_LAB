در ابتدا باید متذکر بشوم که از انجایی که در تمامی پروژه های قبلی در فایل README گزارش را نوشته بودیم پس تصمیم گرفتیم که ریپوهای خود را یکدست نگهداریم بدین ترتیب در این پروژه هم در فایلی با همین نام گزارش و پاسخ به سوالات را نوشتیم و دیگر فایلی با اسم report نساختیم.

در گام اول انجام این پروژه ایتدا مطابق با آزمایش های قبلی یک ریپو ساختیم و شرایط و محدودیت های لازم را به آن اضافه کردیم سپس به سراغ وارد کردن کد پروژه اماده MINIJAVA در پروژه خود رفتیم و کدهای آن را دانلود و به پروژه خود منتقل کردیم. در این مسیر به مشکلاتی اعم از انتخاب درست root project خوردیم که باعث شد تمامی packagin های فایل های این پروژه را خطا بگیرد. خلاصه رسیدیم به گام اول ریفکتورینگ یعنی استفاده از ابزارهایی که در فیلم آموزشی هم به انها اشاره شده بود. در این آزمایش ما از https://getcodeflow.com/ استفاده کردیم.

![Screenshot from 2023-12-06 21-51-48](https://github.com/seyyedAlirezaGhazanfari/refactoring_LAB/assets/59168138/fbd97273-386d-43dc-9e3a-9c9fa0894d78)


این اتفاق و ریپورت برای پروزه خامی بود که به این ابزار داده بودیم البته تعداد زیادی از این خطاها بعدا اوکی شدند و علت آنها هم همانطور که بالاتر به آن اشاره کردم اشتباه در آدرس دهی root بود.
سپس به سراغ ریفکتور و انجام مواردی که در دستور کار آمده بودند شدیم.

اولین موردی که برای یافتن و اصلاح آن به سراغ کد رفتیم Serperate Query From Modifier بود. برای دیدن کدمان هم میتوانید همین عبارت را در لاگ گیت سرچ کنید. کاری که ما کردیم در تابع addMethodLocalVariable در کلاس SymbolTable بود. در این تابع ما توانستیم که پروسه کوئری زدن به متدها و پیدا کردن یکی از آن ها را که بطور کامل در کنار لاجیک خود این تابع قرار داشت را از هم تفکیک کنیم و به یک تابع دیگر منتقل کنیم. 


مورد بعدی استفاده از polymorphism بجای شرط بود. برای این مورد هم با سرج کلید واژه polymorphism در لاگ گیت میتوانید کامیت مربوطه را بیابید. در این کامیت ما به سراغ کلاس Address و تابع toString رفتیم که در آن یک switch-case استفاده شده بود. ما enum مربوطه را حذف کردیم و بجای آن با استفاده از ویژگی های شی گرایی طراحی به عمل آوردیم که هر کدام از این روش های تولید رشته به یکی از پیاده سازهای واسط TypeAddress مپ شود و حال از polymorphism بجای case های متعدد استفاده کردیم.


بازآرایی بعدی که بررسی کردیم سه مورد مختلف از سایر بازآرایی ها بود. ما در این پروژه به extract method، extract variable و inline method پرداخته ایم.
با سرچ کردن هرکدام از این عبارات میتوانید کامیت مدنظر را مشاهده کنید. این سه مورد توضیح ااضافه ای بنظرم نیاز ندارند خیلی واضح هستند در یکی تلاش کردیم یک اکسپرشن بلند رو بشکونیم با استفاده از extract variable با یکی هم توانستیم یک فانکشن بزرگ را بشکونیم تا خواندن و فهمیدن لاجیکش ساده تر شود با استفاده از extract method و با اخری هم فانشکن هایی که بیخودی اضافه شده بودند و صرفا یک خط کد بودند را حذف کردیم با استفاده از inline method.

لینک کامیت های مربوط به هر یک از ریفکتورینگ ها:




# سوال اول
## کد تمیز (clean code)
کد تمیز، کدی است شفاف، قابل فهم و قابل maintaine کردن. کدی است که وقتی شما در حال زدن آن هستید به این موضوع نیز فکر میکنید که در آینده دیگران نیازمند این خواهند بود که کد شما را بخوانند و تفسیر کنند و یا حتی در آن تغییر ایجاد کنند.

## بدهی فنی (technical debt)
بدهی فنی در شرایطی اتفاق می‌افتد که تیم توسعه بدلیل برای مثال ضرورت fast delivery و محدودیت های زمانی که دارد تصمیماتی میگیرد که perfect code در آنها مورد توجه واقع نشده اند و کدهایی تولید میشود که در آینده نیازمند refactoring هستند. به احساس نیاز به این refactoring حاصل از سناریو گفته شد بدهی فنی تیم توسعه گفته میشود.

## بوی بد کد (bad smell (code smell))
الگوهای معمول قابل مشاهده در کدها که پتانسیل تبدیل کردن کد به مشکل و خطا را دارند. باگ نیستند و صرفا نشان دهنده میزان پتانسیل مشکل دار بودن کد است.


# سوال دوم
## دسته اول: Bloaters
در این دسته کدها به شدت از نظر اندازه بزرگ و حجیم شده‌اند و فهم آنها و نگهداری و به طور کلی کار کردن با آنها بسیار سخت است. این دسته از بوها خیلی به تدریح به یکباره در برنامه ظاهر می‌شوند و معمولا در طی رشد سیستم رشد می‌کنند و بعد از مدتی جمع شدن کد و ریفکتور نشدن پدیدار می‌شوند.
<br/>
مثال:
- تابع بلند -> وقتی تابع زیادی بلند شده و نگه‌داری از آن سخت و فهم آن دشوار است.
- کلاس بلند -> کلاسی که زیادی بزرگ است و وظایف متعددی دارد.
- استفاده از دیتای اولیه به صورت بیش از حد -> وقتی کلاس و آبجکت نمی‌سازیم و کلی داده یا dictionary های بزرگ استفاده می‌کنیم.
- لیست آرگومان طویل -> بجای استفاده از شی‌ها همه ویژگی ها تک به تک به توابع پاش می‌شود و پیچیدگی ایجاد می‌کند.
- توده‌ داده -> وقتی ویژگی‌های تکراری در کلاس‌ها مشترک است و تکرار می‌شود.

## دسته دوم: Object-Orientation Abusers
این بوها ناشی از کاربرد ناقص یا نادرست اصول برنامه نویسی شی‌گرا است.
<br/>
مثال:
- کلاس های جایگزین با رابط های مختلف -> وقتی از کلاس های مختلف با عملکرد مشابه اما رابط‌های متفاوت استفاده می‌شود.
- فیلد موقت -> یک فیلد کلاس که فقط برای یک دوره کوتاه یا در شرایط خاص استفاده می شود.

## دسته سوم: Change Preventers
وجود این بوها یعنی در برنامه‌ما برای ایجاد تغییر در یک بخش از کد باید در بخش یا بخش‌های دیگر کد مقدار زیادی تغییر دهیم و این باعث می‌شود که نگهداری و افزودن قابلیت سخت و پرهزینه باشد.
<br/>
مثال:
- تغییر واگرا -> تغییر در یک قسمت از کد مستلزم تغییر در بسیاری از بخش‌های دیگر است.
- سلسله مراتب وراثت موازی -> وقتی دو سلسله مراتب از کلاس‌ها دارید که از یکدیگر تقلید می‌کنند.
- جراحی با شاتگان -> یک تغییر واحد مستلزم تغییرات در بسیاری از کلاس‌های مختلف است.

## دسته چهارم: Dispensables
این بو به چیزهایی اشاره دارد که می‌شود حذفشان کرد شد به طوری که اگر حذف شوند هیچ گونه ضرری به محصول یا سیستم وارد نشود و اتفاقا باعث شود که کد تمیزتر شده و راحت‌تر فهمیده و توسعه داده شود. در واقع چیزهایی که بدون تغییر در عملکرد قابل حذف اند.
‌<br/>
مثال:
- کامنت الکی -> کامنت بیش از حد یا غیر ضروری که ارزش اضافه نمی‌کند یا کد را به خوبی توضیح نمی‌دهد.
- کد تکراری -> بلوک‌های تکراری کد یکسان یا بسیار مشابه.
- کلاس داده -> کلاسی که فقط حاوی داده بدون منطق کاری است.
- کد مرده -> کدی که اجرا نمی‌شود و هیچ هدفی ندارد.
- کلاس تنبل -> کلاس تنبل کلاسی است که کمک زیادی به عملکرد سیستم نمی‌کند. اغلب خیلی کوچک است یا رفتار قابل توجهی برای توجیه وجودش ندارد. کلاس های تنبل معمولا غیر ضروری هستند و حذف آنها طراحی کلی را ساده می کند.

## دسته پنجم: Couplers
تمامی بوهای داخل این گروه مربوط به این هستند که نشان دهند کاپلینگ زیاد وجود دارد و یا نشان دهند که اگر این کاپلینگ را با delegation زیاد از حد عوض کتیم چه اتفاقی میافتد.  
<br/>
مثال:
- حسادت به قابلیت دیگری -> کلاسی که بیش از حد از متدها یا فیلدهای کلاس دیگر استفاده می کند.
- صمیمیت نامناسب -> دانش و تعامل بیش از حد بین کلاس‌ها.
- زنجیره پیام -> دنباله‌ای از تماس تابع‌ ها برای رسیدن به اطلاعات مورد نظر که منجر به اتصال بیش از حد می شود.


# سوال 3:  

#### مورد اول:
این بوی بد در دسته `Dispensables` قرار می‌گیرد. توضیحات آن در بخش قبل آمده است.
#### مورد دوم:
اجزایی که تقریبا کارایی ندارند باید با استفاده از دسته "انتقال قابلیت بین کلاس‌ها" از روش های باز‌آرایی استفاده کنند به طور مثال `inline-class` یا `remove-the-middle-m` برای بازآرایی lazy class مناسب اند. همچنین با استخراج توابع مورد نیاز و قرار دادن آنها در کلاس‌های موجود دیگر نیز می‌توان به این مورد رسیدگی کرد. از طرفی برای زیرکلاس‌هایی با متد‌های اندک می‌توان از بازآرایی `Collapse Hierarchy` استفاده کرد.  
#### مورد سوم:
گاهی امکان دارد یک Lazy Class برای تعیین اهدافمان در توسعه‌های آینده درست شده باشد. در این صورت ما ‌می‌توانیم با رعایت توازن بین وضوح و سادگی کدمان Lazy class را نگه ‌داریم. وقتی کد Lazy class ساده است و یا با احتمال خوبی قرار نیست تغییر در این کلاس ایجاد شود می‌توان وجودش را نادیده گرفت و به موارد مهم‌تر رسیدگی کرد.
