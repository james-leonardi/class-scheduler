# Class Scheduler
Personal class scheduler written around 2019. I still use it every day, even now, as it works very reliably.

I used NetBeans IDE for this project, mostly because it was a great choice for GUI and form editing at the time. This saved a ton of time since I didn't need to concern myself with writing out the long, boring code that handles button/text placement, and could instead focus on the logic of the application.

# Basic Usage
It does exactly what it says - provides a central location to keep track of due dates, assignments, reminders, and the like. There aren't many extraneous features since I had a goal in mind and wanted to keep it simple.

Upon loading the program, you can add new classes with the "Add New" button. The class will now appear in the drop-down menu. Clicking on it will bring you to that class's page, where you can view, add, edit, and remove events related to the class.

Adding or editing an event will bring up a form to input data about the event (type [ex. Homework, Exam], date, and description). The date field uses an external library discussed in the below section.

Going back to the Select... option in the drop-down will bring you to the main page, which shows all of your events from all of your classes in chronological order.

There is also a file manager, where you can attach files to specific classes and open them with your default application depending on the file type. This saves you the hassle of forgetting where you saved a file, but nowadays I've found it more convenient to just use Microsoft Office. Still a cool feature!

I'll (probably) upload images to this document eventually, but for now I wanted to include a basic rundown of what this project is capable of.

# External Libraries
This uses an external library called "jcalendar" for the date selection subinterface. [You can read about it here.](https://toedter.com/jcalendar/)
