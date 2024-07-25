package com.example.androidsample.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidsample.domain.repository.TodoRepository
import com.example.androidsample.ui.viewmodel.TodoViewModel

class ViewModelFactory(
    private val application: Application,
    private val repository: TodoRepository = TodoRepository(application)
) :
    ViewModelProvider.AndroidViewModelFactory(application) {

    // viewModel에 repository를 지정해서 보내야해서 이렇게 factory를 만들어줬다.
    // override 진행
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // MainViewModel 을 만드는 경우에 뭘할지를 지정해준다
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            return TodoViewModel(application = application, repository) as T
        }
        // 그 외에는 일반적으로 동작하겠다.
        return super.create(modelClass)
    }
}