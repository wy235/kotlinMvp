package com.example.kotlinapplication.ui.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.ArrayList

/**
 *作者:wangyu
 *创建时间:2019/11/25 10:38
 *描述:
 */
class LivestockBean : Serializable{

    @SerializedName("id")
    var cattleId: Long = 0//牲畜ID
    var isCheck = false//列表自定义属性，是否选中
    var cattleName: String? = null//牲畜名称
    var farmId: Long = 0//农场ID
    var farmName: String? = null//农场名称
    var deviceId: String? = null//绑定设备ID
    var deviceType: Int = 0//绑定设备类型(1Lora耳标、2蓝牙耳标)
    var deviceTypeDesc: String? = null//绑定设备类型描述
    var earTagId: String? = null//耳标ID
    var regionId: Long = -1//所属围栏ID
    var regionName: String? = null//围栏名称
    var isBindDevice: Int = 0//是否绑定设备 绑定状态 0未绑定 1 绑定
    var isBindDeviceName: String? = null//是否绑定设备名称
    var isHorn = -1//是否有角  默认为-1
    var isHornName: String? = null//是否有角名称
    var labelId: String? = null//标签ID
    var labelName = ""//标签名称
    var gnlis: String? = null//祖父NLIS
    var mnlis: String? = null//母系NLIS
    var nvdNo: String? = null//NVDNumber
    var pnlis: String? = null//父系NLIS
    var bodyColor: Int = 0//牲畜体色
    var bodyColorName: String? = null//牲畜体色名称
    var birthDate: Long = 0//出身日期
    var entryDate: Long = 0//入场时间
    var enterTime: Long = 0  //入栏时间
    var sourceType: Int = 0//来源类型
    var sourceTypeStr: String? = null// 来源类型(中文)
    var supplier: String? = null//供应商
    var supplierPic: String? = null//供应商PIC
    var type: String? = null//类型
    var typeName = ""//类型名称
    var varietyId: String? = null//品种
    var varietyName = ""//品种名称
    var remark: String? = null//备注
    var lat: Double = 0.toDouble()//纬度
    var lng: Double = 0.toDouble()//经度
    var locations: String? = null//地标坐标集
    var positionTime: Long = 0//定位时间
    var mid: Long = 0  //母亲id
    var pid: Long = 0  //父亲id
    var nlis: String? = null  //自身nlis
    var mname: String? = null  //母亲名
    var pname: String? = null  //父亲名
    var visionNum: String? = null  //视觉编码
    var buyTime: Long = 0  //购买日期
    var buyPrice: Long = 0  //购买价格
    var buyWeight: Int = 0 //购买体重
    var storedStatus: Int = 0//存栏状态  10存栏  20出售
    var stageStatus: Int = 0//生理阶段状态
    var stageStatusDesc: String? = null//生理阶段状态描述
    var storedStatusDesc: String? = null//存栏状态描述
    var calfIdList: List<Long> = ArrayList()//后代牲畜Id列表
    var calvingCount: Int = 0  //后代牲畜数量
    var sourceRemark: String? = null  //来源备注
    var operateDeviceType = 0//绑定或者解绑操作 离线 默认为什么都没操作

    override fun toString(): String {
        return "LivestockBean(cattleId=$cattleId, isCheck=$isCheck, cattleName=$cattleName," +
                " farmId=$farmId, farmName=$farmName, deviceId=$deviceId, deviceType=$deviceType, " +
                "deviceTypeDesc=$deviceTypeDesc, earTagId=$earTagId, regionId=$regionId," +
                " regionName=$regionName, isBindDevice=$isBindDevice, " +
                "isBindDeviceName=$isBindDeviceName, isHorn=$isHorn, isHornName=$isHornName, " +
                "labelId=$labelId, labelName='$labelName', gnlis=$gnlis, mnlis=$mnlis, " +
                "nvdNo=$nvdNo, pnlis=$pnlis, bodyColor=$bodyColor, bodyColorName=$bodyColorName," +
                " birthDate=$birthDate, entryDate=$entryDate, enterTime=$enterTime, sourceType=$sourceType," +
                " sourceTypeStr=$sourceTypeStr, supplier=$supplier, supplierPic=$supplierPic," +
                " type=$type, typeName='$typeName', varietyId=$varietyId, varietyName='$varietyName'," +
                " remark=$remark, lat=$lat, lng=$lng, locations=$locations, positionTime=$positionTime," +
                " mid=$mid, pid=$pid, nlis=$nlis, mname=$mname, pname=$pname, visionNum=$visionNum, " +
                "buyTime=$buyTime, buyPrice=$buyPrice, buyWeight=$buyWeight, storedStatus=$storedStatus, " +
                "stageStatus=$stageStatus, stageStatusDesc=$stageStatusDesc, storedStatusDesc=$storedStatusDesc," +
                " calfIdList=$calfIdList, calvingCount=$calvingCount, sourceRemark=$sourceRemark, " +
                "operateDeviceType=$operateDeviceType)"
    }
}