package com.maximmakarov.comparator.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.maximmakarov.comparator.data.model.ItemAttrData


@Dao
interface ItemAttrDataDao : BaseDao<ItemAttrData> {

    @Query("SELECT * FROM attributes_details WHERE item_id = :itemId")
    fun getItemAttributeDetails(itemId: Int): LiveData<List<ItemAttrData>>
}