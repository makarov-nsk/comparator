package com.maximmakarov.comparator.template.add

import androidx.lifecycle.ViewModel
import com.maximmakarov.comparator.data.template.TemplateRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject


class TemplateDetailViewModel : ViewModel(), KoinComponent {

    private val repository: TemplateRepository by inject()

    fun addTemplate(name: String, attributes: String) = repository.addTemplate(name, attributes)

    fun getTemplateById(templateId: Int) = repository.getTemplateById(templateId)

    fun editTemplateName(templateId: Int, name: String) = repository.updateTemplate(templateId, name)
}