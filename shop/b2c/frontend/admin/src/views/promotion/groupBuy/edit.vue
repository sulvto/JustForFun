<template>
  <el-form ref="editForm" :rules="rules" :model="editForm" label-width="100px" size="small" label-position="right">

    <el-form-item label="活动名称" prop="name" required>
      <el-input v-model="editForm.name"></el-input>
    </el-form-item>

    <el-form-item label="活动时间" required>
      <el-date-picker
        v-model="editForm.dateRange"
        type="datetimerange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期">
      </el-date-picker>
    </el-form-item>

    <el-form-item label="最大购买量" required>
      <el-input type="number"  v-model="editForm.maxNumber" >
        <template slot="append">
          件
        </template>
      </el-input>
    </el-form-item>

    <el-form-item label="价格阶梯" required>
      <span class="hint" style="font-size:14px">最小购买</span>
      <el-input type="number" style="width:400px" v-model="editForm.minNumber" >
        <template slot="append">
                件
        </template>
      </el-input>
      <br/>
      <span class="hint" style="font-size:14px">购买价格</span>
      <el-input type="number" style="width:400px" v-model="editForm.price" >
        <template slot="append">
                元
        </template>
      </el-input>
    </el-form-item>

    <el-form-item label="活动说明">
      <el-input type="textarea" v-model="editForm.description"></el-input>
    </el-form-item>

    <el-form-item label="选择商品">
      <SimpleGoodsTable :tableData="editForm.goodsList"/>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('editForm')">保存</el-button>
      <el-button type="info" @click="$router.back()">返回</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import SimpleGoodsTable from '@/components/SimpleGoodsTable.vue'

export default {
  name: 'edit',
  data () {
    return {
      editForm: {
        goodsList: []
      },
      rules: {
        name: [
          { required: true, message: '请输入活动名称', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm () {
      console.log('submitForm', this.editForm)
    }
  },
  components: {
    SimpleGoodsTable
  }
}
</script>

<style lang="scss" scoped>
.hint {
  font-size: 12px;
  line-height: 16px;
  color: #999999;
  margin: 10px 0 0;
}

.important-note {
  color: #ff6600;
  font-style: normal;
}
</style>
