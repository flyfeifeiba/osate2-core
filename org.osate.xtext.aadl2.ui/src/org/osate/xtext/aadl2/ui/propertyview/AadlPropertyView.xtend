/*
 *
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.ui.propertyview

import com.google.inject.Inject
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.Collections
import java.util.List
import java.util.Map
import java.util.Set
import java.util.TreeSet
import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Platform
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.emf.transaction.RunnableWithResult
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.emf.transaction.util.TransactionUtil
import org.eclipse.jface.action.Action
import org.eclipse.jface.action.GroupMarker
import org.eclipse.jface.action.IAction
import org.eclipse.jface.action.MenuManager
import org.eclipse.jface.layout.TreeColumnLayout
import org.eclipse.jface.text.ITextSelection
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.IPostSelectionProvider
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.ISelectionChangedListener
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.StructuredSelection
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.viewers.Viewer
import org.eclipse.swt.SWT
import org.eclipse.swt.events.ModifyEvent
import org.eclipse.swt.events.ModifyListener
import org.eclipse.swt.graphics.GC
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.ui.IPartListener
import org.eclipse.ui.ISelectionListener
import org.eclipse.ui.IWorkbenchActionConstants
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.dialogs.FilteredTree
import org.eclipse.ui.dialogs.PatternFilter
import org.eclipse.ui.part.PageBook
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.ui.editor.IURIEditorOpener
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.IXtextModelListener
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.BehavioralFeature
import org.osate.aadl2.Classifier
import org.osate.aadl2.ContainedNamedElement
import org.osate.aadl2.ContainmentPathElement
import org.osate.aadl2.Element
import org.osate.aadl2.Feature
import org.osate.aadl2.ListValue
import org.osate.aadl2.ModalPath
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.ModeFeature
import org.osate.aadl2.NamedElement
import org.osate.aadl2.PackageSection
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PropertyType
import org.osate.aadl2.Prototype
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RecordValue
import org.osate.aadl2.RefinableElement
import org.osate.aadl2.Subcomponent
import org.osate.xtext.aadl2.ui.MyAadl2Activator

import static org.osate.xtext.aadl2.ui.propertyview.AadlPropertyView.*

import static extension com.google.common.io.CharStreams.*
import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.isSameOrRefines

/**
 * View that displays the AADL property value associations within a given AADL
 * model element.
 *
 * @author aarong
 */
class AadlPropertyView extends ViewPart {
	val static HIDE_UNDEFINED_TOOL_TIP = "Click to hide undefined properties"
	val static SHOW_UNDEFINED_TOOL_TIP = "Click to show undefined properties"
	val static COLLAPSE_ALL_TOOL_TIP = "Collapse All"

	val static NO_PROPERTIES_TO_SHOW = "No properties to show: Please select a single object that is an AADL Property Holder."
	val static POPULATING_VIEW = "Populating AADL Property Values view."
	val static DEFAULT_PROPERTY_GROUP = "All"
	 
	/**
	 * Page book for switching between the tree viewer and the "no properties"
	 * message.
	 */
	var PageBook pageBook = null

	/**
	 * Tree for displaying properties. Underlying model is a
	 * {@link List} of {@link PropertySet} objects.
	 */
	var package TreeViewer treeViewer = null

	var Composite treeViewerComposite = null

	/**
	 * The label for the no results message.
	 */
	var Label noPropertiesLabel = null

	var Label populatingViewLabel = null

	/**
	 * Action for toggling the display of nonexistent properties
	 */
	var package Action showUndefinedAction = null

	var Action removeElementAction = null

	var Action openDefinitionAction = null

	var Action openPropertyAssociationAction = null

	var Action makeLocalAction = null

	var Action createNewAssociationAction = null
	var package nextEditIsANewAssociationCreation = false

	/**
	 * Action for Collapse All.
	 */
	var Action collapseAllAction;


	/**
	 * The editing domain for the viewer's input
	 */
	var EditingDomain editingDomain = null

	var package IXtextDocument xtextDocument = null

	var ResourceSet resourceSetFromSelection = null

	/* Only show properties from this group (or all properties if empty) */
	var Set<String> currentPropertyGroup = new TreeSet

	@Inject
	var package ISerializer serializer

	@Inject
	var IScopeProvider scopeProvider

	@Inject
	var IURIEditorOpener editorOpener

	var URI previousSelectionURI = null

	var CachePropertyLookupJob cachePropertyLookupJob = null
	val jobLock = new Object

	//If the URIs were resolved to EObjects, then this would be a Map<PropertySet, Map<Property, PropertyAssociation>>
	val package Map<URI, Map<URI, URI>> cachedPropertyAssociations = Collections.synchronizedMap(newLinkedHashMap)

	val ISelectionListener selectionListener = [ part, selection |
		/*
		 * Change the view when the selection changes.
		 */
		updateSelection(part, selection)
	]

	val partListener = new IPartListener {
		override partOpened(IWorkbenchPart part) {
		}

		override partDeactivated(IWorkbenchPart part) {
			if (part instanceof XtextEditor) {
				val selectionProvider = part.internalSourceViewer.selectionProvider
				if (selectionProvider instanceof IPostSelectionProvider) {
					selectionProvider.removePostSelectionChangedListener(selectionChangedListener)
				}
			}
		}

		override partClosed(IWorkbenchPart part) {
		}

		override partBroughtToTop(IWorkbenchPart part) {
		}

		override partActivated(IWorkbenchPart part) {
			if (part instanceof XtextEditor) {
				val selectionProvider = part.internalSourceViewer.selectionProvider
				if (selectionProvider instanceof IPostSelectionProvider) {
					selectionProvider.addPostSelectionChangedListener(selectionChangedListener)
				}
			}
		}
	}

	val ISelectionChangedListener selectionChangedListener = [
		updateSelection(site.workbenchWindow.activePage.activeEditor as XtextEditor, selection)]

	//This flag is necessary because calling IURIEditorOpener.open causes a model change event.  This event should be ignored when calling IURIEditorOpener.open
	var modelListenerEnabled = true

	val IXtextModelListener xtextModelListener = [
		if (modelListenerEnabled) {
			synchronized (jobLock) {
				if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
					cachePropertyLookupJob.cancel
				}
				if (input != null) {
					cachePropertyLookupJob = createCachePropertyLookupJob(input, null)
					cachePropertyLookupJob.schedule
				}
			}
		}]

	override createPartControl(Composite parent) {
		pageBook = new PageBook(parent, SWT.NULL)

		noPropertiesLabel = new Label(pageBook, SWT.LEFT) => [
			text = NO_PROPERTIES_TO_SHOW
			alignment = SWT.CENTER
			background = parent.display.getSystemColor(SWT.COLOR_LIST_BACKGROUND)
		]

		populatingViewLabel = new Label(pageBook, SWT.LEFT) => [
			text = POPULATING_VIEW
			alignment = SWT.CENTER
			background = parent.display.getSystemColor(SWT.COLOR_LIST_BACKGROUND)
		]

		treeViewerComposite = new Composite(pageBook, SWT.NULL) => [
			// TreeFilter is jealous; doesn't permit other filters
			// so all our filtering has to be done here
			val patternFilter = new PatternFilter {
				override protected isLeafMatch(Viewer viewer, Object element) {
					val labelProvider = treeViewer.getLabelProvider(0) as ColumnLabelProvider
					val labelText = labelProvider.getText(element)
					return wordMatches(labelText)
						&& (currentPropertyGroup.size == 0 || currentPropertyGroup.contains(labelText))
				}
			}
			// Hack to kill optimization that disables filter when text is empty
			patternFilter.setPattern("org.eclipse.ui.keys.optimization.false")
			
			val treeColumnLayout = new TreeColumnLayout
			val filteredTree = new FilteredTree(it, SWT.BORDER, patternFilter, true) {
				override doCreateTreeViewer(Composite parent, int style) {
					val c = super.doCreateTreeViewer(parent, style)
					c.getControl().setLayoutData(null)
					parent.setLayout(treeColumnLayout)
					return c
				}

				override createFilterControls(Composite parent) {
					val result = super.createFilterControls( parent)

					val Map< String, Set<String>> propertyGroups
						 = newLinkedHashMap(DEFAULT_PROPERTY_GROUP -> new TreeSet())
					val propertyGroupCombo = new Combo(parent, SWT.READ_ONLY) => [
						add( DEFAULT_PROPERTY_GROUP)
						text = DEFAULT_PROPERTY_GROUP
					]
					propertyGroupCombo.addModifyListener(new ModifyListener {
							override modifyText(ModifyEvent e) {
								currentPropertyGroup = propertyGroups.get( propertyGroupCombo.text)
								treeViewer.refresh()
							}
					})
					
			        val fullPathURI = FileLocator.find(Platform.getBundle("org.osate.xtext.aadl2.ui"),
							        					new Path("resources/AadlPropertyGroups.properties"), null)
			        val reader = new InputStreamReader( fullPathURI.openStream())
					for (line : reader.readLines) {
						if (!line.startsWith("#") && line.length > 0) {
	    					val String[] segments = line.split(':')
	    					if (segments.length == 2) {
								propertyGroupCombo.add( segments.get(0))
	    						propertyGroups.put( segments.get(0), segments.get(1).split(",").toSet)
							}
    					}
					}
					reader.close()
 
					if (parent.getLayout() instanceof GridLayout) {
						// previous gridLayout was 2 columns, can't change after initialization
						val newGridLayout = new GridLayout( 3, false) 
						newGridLayout.marginHeight = 0
						newGridLayout.marginWidth = 0
						parent.setLayout(newGridLayout)
					}
					result
				}
			}

			layout = new GridLayout
			val gd = new GridData(SWT.FILL, SWT.FILL, true, true);
			filteredTree.setLayoutData(gd);
			treeViewer = filteredTree.getViewer();
			treeViewer => [ treeViewer |
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					column.text = "Property"
					treeColumnLayout.setColumnData(column, new ColumnWeightData(1, true))
					labelProvider = new PropertyColumnLabelProvider(this)
				]
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					column.text = "Value"
					treeColumnLayout.setColumnData(column, new ColumnWeightData(2, true))
					labelProvider = new ValueColumnLabelProvider(this)
					editingSupport = new ValueColumnEditingSupport(treeViewer, this)
				]
				new TreeViewerColumn(treeViewer, SWT.LEFT) => [
					column.text = "Status"
					val gc = new GC(column.parent)
					treeColumnLayout.setColumnData(column,
						new ColumnPixelData(PropertyStatus.values.map[gc.stringExtent(toString).x].max + 5, true, true))
					gc.dispose
					labelProvider = new StatusColumnLabelProvider(this)
				]
				treeViewer.tree.linesVisible = true
				treeViewer.tree.headerVisible = true
				treeViewer.useHashlookup = true
				treeViewer.contentProvider = new PropertyViewContentProvider(this)
			]
		]

		// Show the "nothing to show" page by default
		pageBook.showPage(noPropertiesLabel)
		site.page.addSelectionListener(selectionListener)
		site.page.addPartListener(partListener)
		val editor = site.page.activeEditor
		if (editor instanceof XtextEditor) {
			val editorSelectionProvider = editor.internalSourceViewer.selectionProvider
			if (editorSelectionProvider instanceof IPostSelectionProvider) {
				editorSelectionProvider.addPostSelectionChangedListener(selectionChangedListener)
			}
		}
		createActions
		createContextMenu
	}

	override dispose() {

		synchronized (jobLock) {
			if (cachePropertyLookupJob != null) {
				cachePropertyLookupJob.cancel
				cachePropertyLookupJob = null
			}
		}
		site.page.removeSelectionListener(selectionListener)
		site.page.removePartListener(partListener)
		val editor = site.page.activeEditor
		if (editor instanceof XtextEditor) {
			val editorSelectionProvider = editor.internalSourceViewer.selectionProvider
			if (editorSelectionProvider instanceof IPostSelectionProvider) {
				editorSelectionProvider.removePostSelectionChangedListener(selectionChangedListener)
			}
		}
		xtextDocument?.removeModelListener(xtextModelListener)
		super.dispose
	}

	override setFocus() {
		treeViewer.tree.setFocus
	}

	def package boolean canEdit(Object element) {
		safeRead[extension it|
			switch treeElement : (element as TreeEntry).treeElement {
				URI:
					switch treeElementEObject : treeElement.getEObject(true) {
						Property: {
							val associationURI = cachedPropertyAssociations.get(
								((element as TreeEntry).parent as TreeEntry).treeElement).get(treeElement)
							getPropertyStatusNeverUndefined(associationURI) == PropertyStatus.LOCAL &&
								!(associationURI.getEObject(true) as PropertyAssociation).modal
						}
						BasicPropertyAssociation: {
							val containingAssociation = treeElementEObject.getContainerOfType(PropertyAssociation)
							getPropertyStatusNeverUndefined(containingAssociation) == PropertyStatus.LOCAL &&
								!containingAssociation.modal
						}
						default:
							false
					}
				RangeElement: {
					val containingAssociation = (treeElement.expressionURI.getEObject(true) as PropertyExpression).
						getContainerOfType(PropertyAssociation)
					getPropertyStatusNeverUndefined(containingAssociation) == PropertyStatus.LOCAL &&
						!containingAssociation.modal
				}
				ListElement: {
					val containingAssociation = (treeElement.expressionURI.getEObject(true) as PropertyExpression).
						getContainerOfType(PropertyAssociation)
					getPropertyStatusNeverUndefined(containingAssociation) == PropertyStatus.LOCAL &&
						!containingAssociation.modal
				}
				default:
					false
			}]
	}

	def package getInput() {
		treeViewer.input as URI
	}

	def private createActions() {
		collapseAllAction = new Action("Collapse All") {
			override run() {
				treeViewer.collapseAll()
			}
		} => [
			imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/collapseall.gif")
			viewSite.actionBars.toolBarManager.add(it)
			toolTipText = COLLAPSE_ALL_TOOL_TIP
		]

		showUndefinedAction = new Action(null, IAction.AS_CHECK_BOX) {
			override run() {
				showUndefinedAction.toolTipText = if (showUndefinedAction.checked) {
					HIDE_UNDEFINED_TOOL_TIP
				} else {
					SHOW_UNDEFINED_TOOL_TIP
				}
				treeViewer.refresh
			}
		} => [
			imageDescriptor = MyAadl2Activator.getImageDescriptor("icons/propertyview/nonexistent_property.gif")
			viewSite.actionBars.toolBarManager.add(it)
			toolTipText = SHOW_UNDEFINED_TOOL_TIP
		]

		removeElementAction = new Action("Remove") {
			override run() {
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				switch treeElement : selectedElement.treeElement {
					URI: {
						val postModificationUpdate = xtextDocument.modify[
							switch treeElementObject : resourceSet.getEObject(treeElement, true) {
								Property: {
									val associationURI = cachedPropertyAssociations.get(
										(selectedElement.parent as TreeEntry).treeElement).get(selectedElement.treeElement)
									val association = resourceSet.getEObject(associationURI, true) as PropertyAssociation
									(association.owner as NamedElement).ownedPropertyAssociations.remove(association);
									[|
										synchronized (jobLock) {
											if (cachePropertyLookupJob != null &&
												cachePropertyLookupJob.state != Job.NONE) {
												cachePropertyLookupJob.cancel
											}
											cachePropertyLookupJob = createCachePropertyLookupJob(input, null)
											cachePropertyLookupJob.schedule
										}]
								}
								BasicPropertyAssociation: {
									(treeElementObject.owner as RecordValue).ownedFieldValues.remove(treeElementObject);
									[|treeViewer.refresh(selectedElement.parent)]
								}
							}]
						postModificationUpdate.apply
					}
					RangeElement: {
						xtextDocument.modify(
							new IUnitOfWork.Void<XtextResource> {
								override process(XtextResource state) throws Exception {
									((state.resourceSet.getEObject((treeElement as RangeElement).expressionURI, true) as PropertyExpression).
										owner as RangeValue).delta = null
								}
							})
						treeViewer.refresh(selectedElement.parent)
					}
					ListElement: {
						xtextDocument.modify(
							new IUnitOfWork.Void<XtextResource> {
								override process(XtextResource state) throws Exception {
									((state.resourceSet.getEObject((treeElement as ListElement).expressionURI, true) as PropertyExpression).
										owner as ListValue).ownedListElements.remove(
										(treeElement as ListElement).index
									)
								}
							})
						treeViewer.refresh(selectedElement.parent)
					}
				}
			}
		}

		openDefinitionAction = new Action("Open Definition") {
			override run() {
				val selectedElementURI = ((treeViewer.selection as IStructuredSelection).firstElement as TreeEntry).
					treeElement as URI
				val uriToOpen = safeRead[extension it|
					switch selectedElement : selectedElementURI.getEObject(true) {
						PropertySet,
						Property,
						BasicProperty: selectedElementURI
						BasicPropertyAssociation: selectedElement.property.URI
					}]
				modelListenerEnabled = false
				editorOpener.open(uriToOpen, true)
				modelListenerEnabled = true
			}
		}

		openPropertyAssociationAction = new Action("Open Property Association") {
			override run() {
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				val uriToOpen = safeRead[ extension it |
					val association = cachedPropertyAssociations.get((selectedElement.parent as TreeEntry).treeElement).
						get(selectedElement.treeElement).getEObject(true) as PropertyAssociation
					val inputElement = input.getEObject(true)
					(if (inputElement instanceof RefinableElement) {
						association.appliesTos.map[containmentPathElements.last].filter [
							namedElement instanceof RefinableElement &&
								(namedElement as RefinableElement).isSameOrRefines(inputElement)
						].head ?: association
					} else {
						association
					}).URI
				]
				modelListenerEnabled = false
				editorOpener.open(uriToOpen, true)
				modelListenerEnabled = true
			}
		}

		makeLocalAction = new Action("Make Local") {
			override run() {
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				val propertyURI = selectedElement.treeElement as URI
				val associationURI = cachedPropertyAssociations.get((selectedElement.parent as TreeEntry).treeElement).
					get(propertyURI)
				xtextDocument.modify(
					new IUnitOfWork.Void<XtextResource> {
						override process(XtextResource state) throws Exception {
							val inputElement = state.resourceSet.getEObject(input, true) as NamedElement
							if (associationURI != null) {
								inputElement.ownedPropertyAssociations.add(
									EcoreUtil.copy(
										state.resourceSet.getEObject(associationURI, true) as PropertyAssociation))
							} else {
								val property = state.resourceSet.getEObject(propertyURI, true) as Property
								inputElement.createOwnedPropertyAssociation => [
									it.property = property
									createOwnedValue => [
										ownedValue = EcoreUtil.copy(property.defaultValue)
									]
								]
							}
						}
					})
				treeViewer.refresh(selectedElement)
			}
		}

		createNewAssociationAction = new Action("Create New Property Association") {
			override run() {
				val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement as TreeEntry
				nextEditIsANewAssociationCreation = true
				treeViewer.editElement(selectedElement, 1)
			}
		}
	}

	def private createContextMenu() {
		new MenuManager => [
			removeAllWhenShown = true
			addMenuListener[
				add(openDefinitionAction)
				add(openPropertyAssociationAction)
				add(createNewAssociationAction)
				add(makeLocalAction)
				add(removeElementAction)
				val selection = treeViewer.selection as IStructuredSelection
				if (selection.size == 1) {
					val firstSelectedElement = selection.firstElement as TreeEntry
					if (firstSelectedElement.treeElement instanceof URI) {
						openDefinitionAction.enabled = safeRead[ extension it |
							val treeElementEObject = (firstSelectedElement.treeElement as URI).getEObject(true)
							treeElementEObject instanceof PropertySet || treeElementEObject instanceof Property ||
								treeElementEObject instanceof BasicPropertyAssociation ||
								treeElementEObject instanceof BasicProperty
						]
						if (safeRead[extension it|
							(firstSelectedElement.treeElement as URI).getEObject(true) instanceof Property]) {
							val propertyStatus = getPropertyStatus(
								(firstSelectedElement.parent as TreeEntry).treeElement as URI,
								firstSelectedElement.treeElement as URI)
							openPropertyAssociationAction.enabled = propertyStatus == PropertyStatus.INHERITED
							createNewAssociationAction.enabled = xtextDocument != null && (propertyStatus ==
								PropertyStatus.INHERITED || propertyStatus == PropertyStatus.DEFAULT ||
								propertyStatus == PropertyStatus.UNDEFINED) && safeRead[ extension it |
								val inputElement = input.getEObject(true)
								inputElement instanceof AadlPackage || inputElement instanceof Classifier ||
									inputElement instanceof Subcomponent || inputElement instanceof ModalPath ||
									inputElement instanceof BehavioralFeature || inputElement instanceof Prototype ||
									inputElement instanceof Feature || inputElement instanceof ModeFeature
							]
							makeLocalAction.enabled = xtextDocument != null &&
								(propertyStatus == PropertyStatus.INHERITED || propertyStatus == PropertyStatus.DEFAULT)
						} else {
							openPropertyAssociationAction.enabled = false
							createNewAssociationAction.enabled = false
							makeLocalAction.enabled = false
						}
					} else {
						openDefinitionAction.enabled = false
						openPropertyAssociationAction.enabled = false
						createNewAssociationAction.enabled = false
						makeLocalAction.enabled = false
					}
					removeElementAction.enabled = xtextDocument != null && canEdit(firstSelectedElement) && switch treeElement : firstSelectedElement.treeElement {
						URI:
							safeRead[extension it|
								switch treeElementEObject : treeElement.getEObject(true) {
									Property:
										true
									BasicPropertyAssociation:
										(treeElementEObject.owner as RecordValue).ownedFieldValues.size >= 2
									default:
										false
								}]
						RangeElement:
							treeElement.label == RangeElement.DELTA_LABEL
						ListElement:
							true
						default:
							false
					}
				} else {
					openDefinitionAction.enabled = false
					openPropertyAssociationAction.enabled = false
					createNewAssociationAction.enabled = false
					makeLocalAction.enabled = false
					removeElementAction.enabled = false
				}
				add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS))
			]
			treeViewer.control.menu = createContextMenu(treeViewer.control)
			site.registerContextMenu(it, treeViewer)
		]
	}
	
	def private updateSelection(IWorkbenchPart part, ISelection selection) {
		xtextDocument?.removeModelListener(xtextModelListener)
		val currentSelection = switch selection {
			case selection.empty: {
				null
			}
			ITextSelection case part instanceof XtextEditor: {
				xtextDocument = (part as XtextEditor).document
				xtextDocument.readOnly[new EObjectAtOffsetHelper().resolveContainedElementAt(it, selection.offset)]
			}
			IStructuredSelection case selection.size == 1: {
				switch selectedObject : selection.firstElement {
					EObject: {
						xtextDocument = null
						selectedObject
					}
					EObjectNode: {
						xtextDocument = selectedObject.document
						selectedObject.readOnly[it]
					}
					IAdaptable: {
						val propertySource = selectedObject.getAdapter(IAadlPropertySource) as IAadlPropertySource
						if (propertySource != null) {
							xtextDocument = propertySource.document
							propertySource.namedElement
						}
					}
				}
			}
		}
		xtextDocument?.addModelListener(xtextModelListener)
		var Object treeElementToSelect
		val currentSelectionURI = try {
			switch currentSelection {
				PropertySet, Property, PropertyType, PropertyConstant, PackageSection: null
				NamedElement:
					currentSelection.URI
				PropertyAssociation case currentSelection.appliesTos.empty: {
					treeElementToSelect = new TreeEntry(
						new TreeEntry(currentSelection.owner.URI,
							currentSelection.property.getContainerOfType(PropertySet).URI), currentSelection.property.URI)
					currentSelection.owner.URI
				}
				PropertyAssociation case currentSelection.appliesTos.size == 1 &&
					currentSelection.appliesTos.head.containmentPathElements.size == 1: {
					treeElementToSelect = new TreeEntry(
						new TreeEntry(
							currentSelection.appliesTos.head.containmentPathElements.head.namedElement.URI,
							currentSelection.property.getContainerOfType(PropertySet).URI
						), currentSelection.property.URI)
					currentSelection.appliesTos.head.containmentPathElements.head.namedElement.URI
				}
				ContainmentPathElement case currentSelection.path == null &&
					currentSelection.owner instanceof ContainedNamedElement: {
					treeElementToSelect = new TreeEntry(
						new TreeEntry(
							currentSelection.namedElement.URI,
							currentSelection.getContainerOfType(PropertyAssociation).property.
								getContainerOfType(PropertySet).URI
						), currentSelection.getContainerOfType(PropertyAssociation).property.URI)
					currentSelection.namedElement.URI
				}
				BasicPropertyAssociation,
				PropertyExpression: {
					val path = new ArrayDeque
					if (currentSelection instanceof BasicPropertyAssociation) {
						path.push(currentSelection.URI)
					}
					var currentElement = currentSelection.owner
					var Element previousElement = currentSelection
					while (currentElement != null && !(currentElement instanceof PropertyAssociation)) {
						switch currentElement {
							ModalPropertyValue case (currentElement.owner as PropertyAssociation).modal,
							BasicPropertyAssociation:
								path.push(currentElement.URI)
							ListValue:
								path.push(
									new ListElement(currentElement.ownedListElements.indexOf(previousElement),
										previousElement.URI))
							RangeValue:
								path.push(
									new RangeElement(
										switch previousElement {
											case currentElement.minimum: RangeElement.MINIMUM_LABEL
											case currentElement.maximum: RangeElement.MAXIMUM_LABEL
											case currentElement.delta: RangeElement.DELTA_LABEL
										}, previousElement.URI))
						}
						previousElement = currentElement
						currentElement = currentElement.owner
					}
					if (currentElement instanceof PropertyAssociation) {
						path.push(currentElement.property.URI)
						val root = if (currentElement.appliesTos.empty) {
								currentElement.owner.URI
							} else if (currentElement.appliesTos.size == 1 &&
								currentElement.appliesTos.head.containmentPathElements.size == 1) {
								currentElement.appliesTos.head.containmentPathElements.head.namedElement.URI
							}
						treeElementToSelect = path.fold(
							new TreeEntry(root, currentElement.property.getContainerOfType(PropertySet).URI),
							[new TreeEntry($0, $1)])
						root
					}
				}
			}
		} catch (NullPointerException e) {
		}
		if (currentSelectionURI != null) {
			editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(currentSelection)
			resourceSetFromSelection = currentSelection.eResource.resourceSet
			if (currentSelectionURI == previousSelectionURI) {
				if (treeElementToSelect != null) {
					treeViewer.setSelection(new StructuredSelection(treeElementToSelect), true)
				}
				pageBook.showPage(treeViewerComposite)
			} else {
				previousSelectionURI = currentSelectionURI

				synchronized (jobLock) {
					if (cachePropertyLookupJob != null && cachePropertyLookupJob.state != Job.NONE) {
						cachePropertyLookupJob.cancel
					}
					cachePropertyLookupJob = createCachePropertyLookupJob(currentSelectionURI, treeElementToSelect)
					cachePropertyLookupJob.schedule
				}
			}
		} else {

			synchronized (jobLock) {
				if (cachePropertyLookupJob != null) {
					cachePropertyLookupJob.cancel
					cachePropertyLookupJob = null
				}
			}
			pageBook.showPage(noPropertiesLabel)
			editingDomain = null
			resourceSetFromSelection = null
			previousSelectionURI = null
		}
	}

	def package <T> safeRead((ResourceSet)=>T operation) {
		if (xtextDocument != null) {
			xtextDocument.readOnly[operation.apply(resourceSet)]
		} else if (editingDomain instanceof TransactionalEditingDomain) {
			try {
				TransactionUtil.runExclusive(editingDomain,
					new RunnableWithResult.Impl<T> {
						override run() {
							result = operation.apply(editingDomain.resourceSet)
							status = Status.OK_STATUS
						}
					})
			} catch (InterruptedException e) {

				//Allow the operation to determine what the result should be
				operation.apply(null)
			}
		} else {
			operation.apply(resourceSetFromSelection)
		}
	}

	def private createCachePropertyLookupJob(URI elementURI, Object objectToSelect) {
		new CachePropertyLookupJob(elementURI, this, site.shell.display, scopeProvider,
			[|
				pageBook.showPage(populatingViewLabel)
			],
			[|
				treeViewer.input = elementURI
				if (objectToSelect != null) {
					treeViewer.setSelection(new StructuredSelection(objectToSelect), true)
				}
				pageBook.showPage(treeViewerComposite)
			])
	}

	def package getPropertyStatus(URI propertySetURI, URI propertyURI) {
		safeRead[ extension it |
			val associationURI = cachedPropertyAssociations.get(propertySetURI).get(propertyURI)
			if (associationURI != null) {
				val association = associationURI.getEObject(true) as PropertyAssociation
				val inputElement = input.getEObject(true)
				if (inputElement == association.owner) {
					PropertyStatus.LOCAL
				} else if (association.appliesTos.exists[inputElement == containmentPathElements.last.namedElement]) {
					PropertyStatus.LOCAL_CONTAINED
				} else {
					PropertyStatus.INHERITED
				}
			} else if ((propertyURI.getEObject(true) as Property).defaultValue != null) {
				PropertyStatus.DEFAULT
			} else {
				PropertyStatus.UNDEFINED
			}
		]
	}

	def private getPropertyStatusNeverUndefined(URI associationURI) {
		if (associationURI != null) {
			safeRead[ extension it |
				val association = associationURI.getEObject(true) as PropertyAssociation
				val inputElement = input.getEObject(true)
				if (inputElement == association.owner) {
					PropertyStatus.LOCAL
				} else if (association.appliesTos.exists[inputElement == containmentPathElements.last.namedElement]) {
					PropertyStatus.LOCAL_CONTAINED
				} else {
					PropertyStatus.INHERITED
				}
			]
		} else {
			PropertyStatus.DEFAULT
		}
	}

	def package getPropertyStatusNeverUndefined(extension ResourceSet resourceSet, PropertyAssociation association) {
		if (association == null) {
			PropertyStatus.DEFAULT
		} else {
			val inputElement = input.getEObject(true)
			if (inputElement == association.owner) {
				PropertyStatus.LOCAL
			} else if (association.appliesTos.exists[inputElement == containmentPathElements.last.namedElement]) {
				PropertyStatus.LOCAL_CONTAINED
			} else {
				PropertyStatus.INHERITED
			}
		}
	}
}
