<template>
  <el-form ref="editForm" :rules="rules" :model="editForm" label-width="120px" size="small" label-position="right">

    <el-form-item label="商品标签名称" prop="name">
      <el-input v-model="editForm.name" placeholder="请输入商品标签名称"></el-input>
    </el-form-item>

    <el-form-item label="排序" >
      <el-input type="number" v-model="editForm.sort"></el-input>
    </el-form-item>

    <!-- TODO: 图片 -->
<!-- <dl>
<dt>标签图片：</dt>
<dd>
<div class="upload-btn-common">
<div>
  <input class="input-file" name="file_upload" id="uploadGroup_pic" type="file" onchange="imgUpload(this);" title="上传">
  <input type="hidden" id="group_pic" value="">
</div>
<input type="text" id="text_group_pic" class="input-common" readonly="readonly" value="">
<em>上传</em>

<img id="preview_group_pic" src="/public/static/blue/img/upload-common-select.png" data-html="true" data-container="body" data-placement="top" data-trigger="manual">

</div>
<p class="hint">
<span>建议使用<i class="important-note">宽200</i>像素-<i class="important-note">高60</i>像素内的<i class="important-note">GIF</i>或<i class="important-note">PNG</i>透明图片；点击下方"保存"按钮后生效。</span>
</p>
</dd>
</dl> -->

    <el-form-item label="商品标签描述" >
      <el-input type="textarea" v-model="editForm.description"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('editForm')">保存</el-button>
      <el-button type="info" @click="$router.back()">返回</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: 'edit',
  data () {
    return {
      editForm: {},
      rules: {
        name: [
          { required: true, message: '请输入商品标签名称', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm () {
      console.log('submitForm', this.editForm)
    }
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
