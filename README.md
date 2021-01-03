
Android DarkTheme Test Application
==================================

This application provides a change in the lifecycle of the activity restart when the theme is changed.

Logs of the Lifecycle
----------------------

- Application Flow  
`MainActivity -> SecondActivity + SecondFragment`

1. Theme Changed Event
```
D/MainActivity: onDestroy
D/MainActivity: onCreate savedInstanceState is null false
D/MainActivity: onStart
D/MainActivity: onRestoreInstanceState
    onResume
D/MainActivity: onPause
D/MainActivity: onStop
D/MainActivity: onSaveInstanceState
D/SecondFragment: onPause
D/SecondActivity: onPause
D/SecondFragment: onStop
D/SecondActivity: onStop
D/SecondActivity: onSaveInstanceState
D/SecondFragment: onDestroyView
D/SecondFragment: onDetach
D/SecondActivity: onDestroy
D/SecondFragment: onAttach
D/SecondFragment: onCreate
D/SecondActivity: onCreate savedInstanceState is null false
D/SecondFragment: onActivityCreated
D/SecondFragment: onStart
D/SecondActivity: onStart
D/SecondActivity: onRestoreInstanceState
D/SecondActivity: onResume
D/SecondFragment: onResume
```

2. Screen Rotated Event (**Configuration Changed**)
```
D/SecondFragment: onPause
D/SecondActivity: onPause
D/SecondFragment: onStop
D/SecondActivity: onStop
    onSaveInstanceState
D/SecondFragment: onDestroyView
D/SecondFragment: onDetach
D/SecondActivity: onDestroy
D/SecondFragment: onAttach
    onCreate
D/SecondActivity: onCreate savedInstanceState is null false
D/SecondFragment: onActivityCreated
    onStart
D/SecondActivity: onStart
D/SecondActivity: onRestoreInstanceState
    onResume
D/SecondFragment: onResume
```

- Conclusion  
The theme change event and the screen rotation event are similar in that **saveInstanceState callback method** is called to keep data of the previous activity as the activity restarts.  
In addition, the theme change event restarts the previous activity as well as the current activity.
